package com.ht.scada.web.mvc;

import com.ht.scada.common.tag.entity.EndTag;
import com.ht.scada.common.tag.entity.EndTagExtInfo;
import com.ht.scada.common.tag.entity.MajorTag;
import com.ht.scada.common.tag.entity.SensorDevice;
import com.ht.scada.common.tag.entity.TagCfgTpl;
import com.ht.scada.common.tag.service.EndTagService;
import com.ht.scada.common.tag.service.MajorTagService;
import com.ht.scada.common.tag.service.TagService;
import com.ht.scada.common.tag.type.service.TypeService;
import com.ht.scada.common.tag.util.EndTagExtNameEnum;
import com.ht.scada.common.tag.util.EndTagTypeEnum;
import com.ht.scada.common.tag.util.VarGroupEnum;
import com.ht.scada.common.tag.util.VarSubTypeEnum;
import com.ht.scada.data.service.HistoryDataService;
import com.ht.scada.data.service.RealtimeDataService;
import com.ht.scada.oildata.entity.ChouYouGanShouLi;
import com.ht.scada.oildata.entity.WellDGTData;
import com.ht.scada.oildata.entity.WellData;
import com.ht.scada.oildata.service.WellService;
import com.ht.scada.security.entity.User;
import com.ht.scada.security.service.UserService;
import com.ht.scada.web.entity.UserExtInfo;
import com.ht.scada.web.service.UserExtInfoService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 实时监控Controller
 *
 * @author hxy
 */
@Controller
@RequestMapping(value = "/realtime")
public class RealTimeController {
    private static final Logger log = LoggerFactory.getLogger(UserAdminController.class);
    
    @Autowired
	private UserService userService;
    @Autowired
	private UserExtInfoService userExtInfoService;
    @Autowired
    private EndTagService endTagService;
    @Autowired
    private MajorTagService majorTagService;
    @Autowired
    private RealtimeDataService realtimeDataService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private HistoryDataService historyDataService;
    @Autowired
    private WellService wellService;
    /**
     * 按登录用户权限返回油井信息,返回格式为JSON
     * 
     * @return 当前用户有权限的油井信息
     */
    @RequestMapping(value="youjing")
    @ResponseBody
    public List<Map> youJingList(){
        User user = userService.getCurrentUser();
        UserExtInfo userExtInfo = userExtInfoService.findUserExtInfoByUserID(user.getId());
        Set<Integer> set = userExtInfo.getEndTagID();
        List<Map> list = new ArrayList<>();
        for(int id : set){
            EndTag endTag = endTagService.getById(id);
            if(endTag.getType().equals(EndTagTypeEnum.YOU_JING.toString())){
                HashMap map = new HashMap();
                map.put("id", endTag.getId());
                map.put("code", endTag.getCode());
                map.put("name", endTag.getName());
                map.put("type", endTag.getType());
                map.put("subtype", endTag.getSubType());
                map.put("major_tag_id",endTag.getMajorTag().getId());
                map.put("state",realtimeDataService.getEndTagVarInfo(endTag.getCode(), VarSubTypeEnum.QI_TING_ZHUANG_TAI.toString().toLowerCase()));
                List<EndTagExtInfo> extList = endTag.getExtInfo();
                for(EndTagExtInfo ext : extList){
                    if(ext.getKeyName().equals(EndTagExtNameEnum.STAGE.toString())){
                        map.put("stage", ext.getValue());
                        break;
                    }
                }
                list.add(map);
            }
        }
        return list;
    }
    
    /**
     * 按登录用户权限返回机构信息,返回格式为JSON
     * 
     * @return 当前用户有权限的机构信息
     */
    @RequestMapping(value="majortag")
    @ResponseBody
    public List<Map> majorTagList(){
        User user = userService.getCurrentUser();
        UserExtInfo userExtInfo = userExtInfoService.findUserExtInfoByUserID(user.getId());
        Set<Integer> set = userExtInfo.getMajorTagID();
        List<Map> list = new ArrayList<>();
        for(int id : set){
            MajorTag majorTag = majorTagService.getById(id);
            HashMap map = new HashMap();
            map.put("id", majorTag.getId());
            map.put("name", majorTag.getName());
            map.put("type", majorTag.getType());
            MajorTag ptag = majorTag.getParent();
            if(ptag == null){
                map.put("pid", 0);
            }else{
                map.put("pid",ptag.getId());
            }
            
            list.add(map);
        }
        return list;
    }
    
    /**
     * 按登录用户权限返回增压站信息,返回格式为JSON
     * 
     * @return 当前用户有权限的增压站信息
     */
    @RequestMapping(value="zengya")
    @ResponseBody
    public List<Map> zengyaList(){
        User user = userService.getCurrentUser();
        UserExtInfo userExtInfo = userExtInfoService.findUserExtInfoByUserID(user.getId());
        Set<Integer> set = userExtInfo.getEndTagID();
        List<Map> list = new ArrayList<>();
        for(int id : set){
            EndTag endTag = endTagService.getById(id);
            if(endTag.getType().equals(EndTagTypeEnum.ZENG_YA_ZHAN.toString())){
                HashMap map = new HashMap();
                map.put("id", endTag.getId());
                map.put("code", endTag.getCode());
                map.put("name", endTag.getName());
                map.put("type", endTag.getType());
                map.put("major_tag_id",endTag.getMajorTag().getId());
                map.putAll(realtimeDataService.getEndTagVarGroupInfo(endTag.getCode(), VarGroupEnum.ZYZ_YC.toString()));
                list.add(map);
            }
        }
        return list;
    }
    
    /**
     * 按登录用户权限返回注水站信息,返回格式为JSON
     * 
     * @return 当前用户有权限的注水站信息
     */
    @RequestMapping(value="zhushuizhan")
    @ResponseBody
    public List<Map> zhushuizhan(){
        User user = userService.getCurrentUser();
        UserExtInfo userExtInfo = userExtInfoService.findUserExtInfoByUserID(user.getId());
        Set<Integer> set = userExtInfo.getEndTagID();
        List<Map> list = new ArrayList<>();
        for(int id : set){
            EndTag endTag = endTagService.getById(id);
            if(endTag.getType().equals(EndTagTypeEnum.ZHU_SHUI_ZHAN.toString())){
                HashMap map = new HashMap();
                map.put("id", endTag.getId());
                map.put("code", endTag.getCode());
                map.put("name", endTag.getName());
                map.put("type", endTag.getType());
                map.put("major_tag_id",endTag.getMajorTag().getId());
                map.putAll(realtimeDataService.getEndTagVarGroupInfo(endTag.getCode(), VarGroupEnum.ZSZ_YC.toString()));
                list.add(map);
            }
        }
        return list;
    }
    /**
     * 按登录用户权限返回接转站信息,返回格式为JSON
     * 
     * @return 当前用户有权限的接转站信息
     */
    @RequestMapping(value="jiezhuanzhan")
    @ResponseBody
    public List<Map> jiezhuanzhan(){
        User user = userService.getCurrentUser();
        UserExtInfo userExtInfo = userExtInfoService.findUserExtInfoByUserID(user.getId());
        Set<Integer> set = userExtInfo.getEndTagID();
        List<Map> list = new ArrayList<>();
        for(int id : set){
            EndTag endTag = endTagService.getById(id);
            if(endTag.getType().equals(EndTagTypeEnum.JIE_ZHUAN_ZHAN.toString())){
                HashMap map = new HashMap();
                map.put("id", endTag.getId());
                map.put("code", endTag.getCode());
                map.put("name", endTag.getName());
                map.put("type", endTag.getType());
                map.put("major_tag_id",endTag.getMajorTag().getId());
                map.putAll(realtimeDataService.getEndTagVarGroupInfo(endTag.getCode(), VarGroupEnum.JZZ_YC.toString()));
                list.add(map);
            }
        }
        return list;
    }
    
    @RequestMapping(value="etinfo")
    @ResponseBody
    public Map endTagExtInfo(String code){
        EndTag endTag = endTagService.getByCode(code);
        Map<String,String> map = new HashMap();
        for(EndTagExtInfo info : endTag.getExtInfo()){
            map.put(info.getName(), info.getValue());
        }
        return map;
    }
    @RequestMapping(value="groupinfo")
    @ResponseBody
    public List<Map> rtu(String code,String group){
        List<Map> rtn = new ArrayList<>();
        Map<String,String> map;
        map = realtimeDataService.getEndTagVarGroupInfo(code, group);
        for(Map.Entry<String,String> entry : map.entrySet()){
            Map tmp = new HashMap<>();
            tmp.put("key", entry.getKey());
            tmp.put("value", entry.getValue());
            TagCfgTpl cfgtpl = tagService.getTagCfgTplByCodeAndVarName(code, entry.getKey());
            tmp.put("name", cfgtpl.getTagName());
            rtn.add(tmp);
        }
        return rtn;
    }
    @RequestMapping(value="sensor")
    @ResponseBody
    public List<Map> sensor(String code){
        Date curDate = new Date();
        List<Map> data = new ArrayList<>();
        List<String> sensor= new ArrayList<>();
        List<String> keyname= new ArrayList<>();
        Map<String,String> map;
        map = realtimeDataService.getEndTagVarGroupInfo(code, VarGroupEnum.SENSOR_RUN.toString());
        for(String key:map.keySet()){
            String[] arr =key.split("\\|");
            if(!sensor.contains(arr[1])){
                sensor.add(arr[1]);
            }
            if(!keyname.contains(arr[0])){
                keyname.add(arr[0]);
            }
        }
        Calendar cal = Calendar.getInstance();
        for(String nickname:sensor){
            Map tmp = new HashMap();
            SensorDevice sen = tagService.getSensorDeviceByCodeAndNickName(code, nickname);
            cal.setTime(sen.getFixTime());
            cal.add(Calendar.DATE, Integer.parseInt(sen.getCheckInterval()));
            if(cal.before(curDate)){
                map.put("biaoding", "1");
            }else{
                map.put("biaoding", "0");
            }
            String name = sen.getName();
            //计算标定
            tmp.put("sensorname", name);
            tmp.put("nickname", nickname);
            for(String key:keyname){
                String val = map.get(key + "|" + nickname);
                tmp.put(key, val);
            }
            data.add(tmp);
        }
        return data;
    }
    @RequestMapping(value="linedata")
    @ResponseBody
    public Object LineData(String code,String group, String varName){
        Date endDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -1);
        Date startDate = cal.getTime();
        return historyDataService.getVarTimeSeriesData(code, VarGroupEnum.valueOf(group), varName, startDate, endDate);
    }
    @RequestMapping(value="welldata")
    @ResponseBody
    public WellData wellData(String code){
        WellData wellData = null;
        try {
            wellData = wellService.getLatestWellDataByWellNum(code);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return wellData;
    }
    @RequestMapping(value="welldgtdata")
    @ResponseBody
    public WellDGTData wellDGTData(String code){
        WellDGTData wellDGTData = null;
        try {
            wellDGTData = wellService.getLatestWellDGTDataByWellNum(code);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return wellDGTData;
    }
    @RequestMapping(value="cygshouli")
    @ResponseBody
    public List<ChouYouGanShouLi> cygShouLi(String code){
        return wellService.getLatestCYGShouLi(code);
    }
    @RequestMapping(value="sensordevice")
    @ResponseBody
    public List<SensorDevice> sensorDevice(String code) {
        return tagService.getSensorDeviceByCode(code);
        
    }
    
}
