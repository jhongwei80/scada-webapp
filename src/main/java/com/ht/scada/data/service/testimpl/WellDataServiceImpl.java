package com.ht.scada.data.service.testimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ht.scada.oildata.entity.ChouYouGanShouLi;
import com.ht.scada.oildata.entity.WellDGTData;
import com.ht.scada.oildata.entity.WellData;
import com.ht.scada.oildata.service.WellService;
import org.springframework.stereotype.Service;

/**
 * @author 赵磊
 *
 */
@Service
public class WellDataServiceImpl implements WellService {

	@Override
	public List<WellData> getWellDataByWellNumAndDatetime(String wellNum,
		Date startTime, Date endTime){
		List<WellData> list = new ArrayList<>();
		list.add(getWellData());
		list.add(getWellData());
		list.add(getWellData());
		list.add(getWellData());
		list.add(getWellData());
		list.add(getWellData());
		list.add(getWellData());
		list.add(getWellData());
		list.add(getWellData());
		list.add(getWellData());
		list.add(getWellData());
		list.add(getWellData());
		return list;
	}

	@Override
	public WellData getWellDataByWellNumAndDatetime(String wellNum, Date time) {
		
		return getWellData();
	}

	@Override
	public WellData getLatestWellDataByWellNum(String wellNum){
		
		return getWellData();
	}

	@Override
	public List<ChouYouGanShouLi> getLatestCYGShouLi(String wellNum) {
		List<ChouYouGanShouLi> cygslList = new ArrayList<>();
		ChouYouGanShouLi cyg1 = new ChouYouGanShouLi();
		cyg1.setIndex("一级杆");
		cyg1.setMaxZaiHe("89.1");
		cyg1.setMinZaihe("12.1");
		
		ChouYouGanShouLi cyg2 = new ChouYouGanShouLi();
		cyg2.setIndex("二级杆");
		cyg2.setMaxZaiHe("83.1");
		cyg2.setMinZaihe("22.1");
		
		cygslList.add(cyg1);
		cygslList.add(cyg2);
		
		return cygslList;
	}

	@Override
	public WellDGTData getLatestWellDGTDataByWellNum(String wellNum){
		WellDGTData dgt = new WellDGTData();
		dgt.setCode(wellNum);
		dgt.setWeiyi(getWeiYi());
		dgt.setIb(getIb());
		dgt.setPower(getPower());
		dgt.setPower_factor(getPowerFactor());
		dgt.setTime(new Date());
		return dgt;
	}
	
	private WellData getWellData() {
		WellData wellData = new WellData();
		wellData.setCode("wellNum");
		
		wellData.setBengXiao(0.9f);
		wellData.setChanYeLiang(70.9f);
		wellData.setFalutDiagnoseInfo("产液量不足");
		wellData.setPingHengDu(0.98f);
		wellData.setChongCheng(4.5f);
		wellData.setChongChengTime(54.3f);
		wellData.setShangChongChengTime(24.3f);
		wellData.setXiaChongChengTime(30f);
		wellData.setChongCi(1.2f);
		wellData.setRiHaoDian(3.4f);
		wellData.setDianBiaoNum(456.3f);
		wellData.setMaxZaihe(55.4f);
		wellData.setMinZaihe(12.4f);
		wellData.setNenghaoXia(12.3f);
		wellData.setNenghaoShang(13.2f);
		
		wellData.setWeiyi(getWeiYi());
		wellData.setZaihe(getZaiHe());
		wellData.setTime(new Date());
		
		return wellData;
	}
	
//	private float[] getArray() {
//		float[] f = new  float[10];
//		f[0] = 1;
//		f[9] = 1;
//		Random r = new Random();
//		f[1] = Math.abs(r.nextInt())%10;
//		f[2] = Math.abs(r.nextInt())%10;
//		f[3] = Math.abs(r.nextInt())%10;
//		f[4] = Math.abs(r.nextInt())%10;
//		f[5] = Math.abs(r.nextInt())%10;
//		f[6] = Math.abs(r.nextInt())%10;
//		f[7] = Math.abs(r.nextInt())%10;
//		f[8] = Math.abs(r.nextInt())%10;
//		
//		return f;
//	}

    @Override
    public WellDGTData geWellDGTDataByWellNumAndDatetime(String wellNum, Date time) {
        		WellDGTData dgt = new WellDGTData();
		dgt.setCode(wellNum);
		dgt.setWeiyi(getWeiYi());
		dgt.setIb(getIb());
		dgt.setPower(getPower());
		dgt.setPower_factor(getPowerFactor());
		dgt.setTime(new Date());
		return dgt;
    }
    
    private float[] getWeiYi() {
	    float[] weiyi = {0.925000011920929F, 0.949999988079071F, 0.97500002384185791F, 1.0130000114440918F, 1.0509999990463257F, 1.1019999980926514F, 1.1529999971389771F, 1.2039999961853027F, 1.2539999485015869F, 1.3049999475479126F, 1.3559999465942383F, 1.406000018119812F, 1.4570000171661377F, 1.5199999809265137F, 1.5709999799728394F, 1.621999979019165F, 1.6599999666213989F, 1.7109999656677246F, 1.7610000371932983F, 1.812000036239624F, 1.8630000352859497F, 1.9129999876022339F, 1.9769999980926514F, 2.0150001049041748F, 2.065000057220459F, 2.1159999370574951F, 2.1670000553131104F, 2.2170000076293945F, 2.2679998874664307F, 2.3190000057220459F, 2.369999885559082F, 2.4330000877380371F, 2.4839999675750732F, 2.5220000743865967F, 2.5720000267028809F, 2.622999906539917F, 2.6740000247955322F, 2.7239999771118164F, 2.7880001068115234F, 2.8259999752044678F, 2.877000093460083F, 2.9270000457763672F, 2.9779999256134033F, 3.0290000438690186F, 3.0789999961853027F, 3.1429998874664307F, 3.1930000782012939F, 3.24399995803833F, 3.2820000648498535F, 3.3199999332427979F, 3.3840000629425049F, 3.4470000267028809F, 3.497999906539917F, 3.5610001087188721F, 3.6119999885559082F, 3.6500000953674316F, 3.7000000476837158F, 3.73799991607666F, 3.8020000457763672F, 3.8519999980926514F, 3.9030001163482666F, 3.9670000076293945F, 4.0170001983642578F, 4.054999828338623F, 4.1059999465942383F, 4.1570000648498535F, 4.21999979019165F, 4.2709999084472656F, 4.3090000152587891F, 4.3720002174377441F, 4.434999942779541F, 4.4860000610351562F, 4.51200008392334F, 4.5749998092651367F, 4.625999927520752F, 4.689000129699707F, 4.7399997711181641F, 4.7899999618530273F, 4.8410000801086426F, 4.8920001983642578F, 4.929999828338623F, 4.9930000305175781F, 5.0440001487731934F, 5.09499979019165F, 5.1449999809265137F, 5.1960000991821289F, 5.2470002174377441F, 5.2969999313354492F, 5.3480000495910645F, 5.39900016784668F, 5.4619998931884766F, 5.5130000114440918F, 5.564000129699707F, 5.6020002365112305F, 5.6269998550415039F, 5.6649999618530273F, 5.6779999732971191F, 5.690000057220459F, 5.7030000686645508F, 5.7030000686645508F, 5.7030000686645508F, 5.690000057220459F, 5.6649999618530273F, 5.6399998664855957F, 5.6020002365112305F, 5.564000129699707F, 5.5130000114440918F, 5.4619998931884766F, 5.39900016784668F, 5.3480000495910645F, 5.2969999313354492F, 5.2470002174377441F, 5.1960000991821289F, 5.1449999809265137F, 5.09499979019165F, 5.0310001373291016F, 4.9930000305175781F, 4.929999828338623F, 4.8920001983642578F, 4.8410000801086426F, 4.7779998779296875F, 4.7270002365112305F, 4.6760001182556152F, 4.625999927520752F, 4.5749998092651367F, 4.52400016784668F, 4.4739999771118164F, 4.4229998588562012F, 4.3470001220703125F, 4.3090000152587891F, 4.2579998970031738F, 4.2069997787475586F, 4.1570000648498535F, 4.1059999465942383F, 4.0430002212524414F, 3.9920001029968262F, 3.9409999847412109F, 3.8910000324249268F, 3.8269999027252197F, 3.7760000228881836F, 3.73799991607666F, 3.687999963760376F, 3.63700008392334F, 3.5859999656677246F, 3.5230000019073486F, 3.4719998836517334F, 3.4089999198913574F, 3.3580000400543213F, 3.3199999332427979F, 3.2690000534057617F, 3.2060000896453857F, 3.1549999713897705F, 3.1050000190734863F, 3.0539999008178711F, 3.003000020980835F, 2.9530000686645508F, 2.9019999504089355F, 2.8510000705718994F, 2.8010001182556152F, 2.75F, 2.6860001087188721F, 2.6480000019073486F, 2.5980000495910645F, 2.5469999313354492F, 2.4839999675750732F, 2.4460000991821289F, 2.3819999694824219F, 2.3320000171661377F, 2.2679998874664307F, 2.2170000076293945F, 2.1789999008178711F, 2.1289999485015869F, 2.0780000686645508F, 2.0269999504089355F, 1.9639999866485596F, 1.9129999876022339F, 1.8630000352859497F, 1.812000036239624F, 1.7610000371932983F, 1.7109999656677246F, 1.6599999666213989F, 1.6089999675750732F, 1.5579999685287476F, 1.5080000162124634F, 1.4440000057220459F, 1.3940000534057617F, 1.343000054359436F, 1.2920000553131104F, 1.2419999837875366F, 1.1909999847412109F, 1.1399999856948853F, 1.0889999866485596F, 1.0509999990463257F, 1.0010000467300415F, 0.97500002384185791F, 0.93699997663497925F, 0.925000011920929F, 0.91200000047683716F, 0.89899998903274536F, 0.89899998903274536F};
	    return weiyi;
    }
    
    private float[] getZaiHe() {
    	float[] zaihe = {33.349998474121094F, 39.060001373291016F, 37.810001373291016F, 35.849998474121094F, 43.159999847412109F, 46.549999237060547F, 46.900001525878906F, 53.860000610351562F, 50.830001831054688F, 59.75F, 59.209999084472656F, 54.220001220703125F, 53.680000305175781F, 58.139999389648438F, 59.569999694824219F, 54.389999389648438F, 53.680000305175781F, 59.569999694824219F, 53.860000610351562F, 54.930000305175781F, 59.209999084472656F, 53.5F, 59.569999694824219F, 54.75F, 53.680000305175781F, 59.389999389648438F, 53.5F, 59.569999694824219F, 54.220001220703125F, 56.0F, 56.529998779296875F, 54.220001220703125F, 55.459999084472656F, 56.0F, 56.0F, 54.75F, 56.889999389648438F, 53.860000610351562F, 59.209999084472656F, 53.5F, 58.849998474121094F, 53.680000305175781F, 55.459999084472656F, 58.849998474121094F, 54.220001220703125F, 59.209999084472656F, 53.680000305175781F, 59.569999694824219F, 53.5F, 58.5F, 55.110000610351562F, 55.459999084472656F, 58.139999389648438F, 53.860000610351562F, 59.569999694824219F, 53.680000305175781F, 59.569999694824219F, 53.5F, 57.069999694824219F, 59.209999084472656F, 53.680000305175781F, 59.569999694824219F, 53.5F, 57.599998474121094F, 59.209999084472656F, 53.5F, 56.0F, 59.209999084472656F, 53.5F, 56.0F, 59.569999694824219F, 53.680000305175781F, 54.040000915527344F, 59.389999389648438F, 57.430000305175781F, 53.5F, 58.849998474121094F, 59.029998779296875F, 53.5F, 57.069999694824219F, 59.389999389648438F, 53.5F, 54.75F, 59.389999389648438F, 55.459999084472656F, 53.5F, 56.360000610351562F, 59.389999389648438F, 53.680000305175781F, 53.680000305175781F, 59.389999389648438F, 58.139999389648438F, 53.5F, 55.459999084472656F, 59.389999389648438F, 56.180000305175781F, 53.319999694824219F, 56.180000305175781F, 59.209999084472656F, 53.319999694824219F, 53.319999694824219F, 58.5F, 58.849998474121094F, 52.610000610351562F, 52.080001831054688F, 52.610000610351562F, 54.040000915527344F, 51.900001525878906F, 48.150001525878906F, 43.869998931884766F, 35.310001373291016F, 38.340000152587891F, 33.169998168945312F, 38.880001068115234F, 32.9900016784668F, 38.880001068115234F, 32.9900016784668F, 37.630001068115234F, 34.779998779296875F, 33.880001068115234F, 38.880001068115234F, 32.9900016784668F, 34.060001373291016F, 38.880001068115234F, 32.9900016784668F, 36.560001373291016F, 37.630001068115234F, 32.9900016784668F, 36.380001068115234F, 38.700000762939453F, 32.9900016784668F, 36.380001068115234F, 38.880001068115234F, 33.169998168945312F, 33.349998474121094F, 38.880001068115234F, 33.169998168945312F, 33.169998168945312F, 38.880001068115234F, 33.529998779296875F, 33.529998779296875F, 38.880001068115234F, 32.9900016784668F, 33.349998474121094F, 38.880001068115234F, 33.529998779296875F, 33.169998168945312F, 38.880001068115234F, 34.2400016784668F, 33.169998168945312F, 38.880001068115234F, 33.880001068115234F, 33.529998779296875F, 38.880001068115234F, 32.9900016784668F, 34.2400016784668F, 38.880001068115234F, 33.169998168945312F, 33.169998168945312F, 38.340000152587891F, 38.159999847412109F, 32.9900016784668F, 37.270000457763672F, 38.340000152587891F, 32.9900016784668F, 36.7400016784668F, 38.880001068115234F, 32.9900016784668F, 33.700000762939453F, 38.880001068115234F, 36.380001068115234F, 32.9900016784668F, 36.919998168945312F, 38.880001068115234F, 33.169998168945312F, 33.169998168945312F, 38.880001068115234F, 38.340000152587891F, 32.9900016784668F, 33.169998168945312F, 37.810001373291016F, 38.880001068115234F, 36.380001068115234F, 32.9900016784668F, 33.529998779296875F, 38.880001068115234F, 38.159999847412109F, 32.9900016784668F, 32.9900016784668F, 33.700000762939453F, 38.340000152587891F, 38.880001068115234F, 34.419998168945312F, 32.9900016784668F, 35.310001373291016F, 39.060001373291016F, 38.700000762939453F, 33.169998168945312F, 33.349998474121094F, 35.849998474121094F};
    	return zaihe;
    }
    
    private float[] getIb() {
    	float[] ib = {17.299999237060547F, 17.600000381469727F, 17.5F, 18.200000762939453F, 19.700000762939453F, 19.299999237060547F, 20.100000381469727F, 20.899999618530273F, 22.299999237060547F, 23.200000762939453F, 23.600000381469727F, 24.600000381469727F, 22.700000762939453F, 22.200000762939453F, 22.100000381469727F, 22.299999237060547F, 23.600000381469727F, 23.600000381469727F, 23.799999237060547F, 22.200000762939453F, 23.5F, 21.899999618530273F, 22.5F, 23.700000762939453F, 23.399999618530273F, 22.299999237060547F, 21.399999618530273F, 23.399999618530273F, 22.700000762939453F, 23.0F, 22.200000762939453F, 23.5F, 22.5F, 21.700000762939453F, 23.0F, 23.299999237060547F, 23.100000381469727F, 22.0F, 22.5F, 22.399999618530273F, 23.200000762939453F, 22.700000762939453F, 23.299999237060547F, 23.5F, 22.100000381469727F, 22.399999618530273F, 22.399999618530273F, 23.600000381469727F, 22.600000381469727F, 22.700000762939453F, 21.200000762939453F, 22.0F, 22.600000381469727F, 22.299999237060547F, 23.299999237060547F, 22.100000381469727F, 22.299999237060547F, 21.799999237060547F, 22.5F, 23.100000381469727F, 23.399999618530273F, 23.200000762939453F, 22.200000762939453F, 22.100000381469727F, 22.200000762939453F, 22.799999237060547F, 23.600000381469727F, 23.399999618530273F, 22.600000381469727F, 21.399999618530273F, 22.200000762939453F, 22.200000762939453F, 22.899999618530273F, 23.799999237060547F, 22.600000381469727F, 22.200000762939453F, 21.299999237060547F, 21.799999237060547F, 22.700000762939453F, 22.899999618530273F, 21.700000762939453F, 22.200000762939453F, 22.299999237060547F, 21.299999237060547F, 22.200000762939453F, 22.100000381469727F, 22.899999618530273F, 21.399999618530273F, 21.100000381469727F, 22.799999237060547F, 23.600000381469727F, 21.600000381469727F, 20.899999618530273F, 20.799999237060547F, 19.600000381469727F, 19.5F, 18.799999237060547F, 18.100000381469727F, 17.700000762939453F, 17.399999618530273F, 16.899999618530273F, 17.0F, 17.0F, 17.299999237060547F, 17.5F, 17.5F, 16.899999618530273F, 16.600000381469727F, 16.700000762939453F, 17.200000762939453F, 17.0F, 17.0F, 17.200000762939453F, 17.200000762939453F, 17.100000381469727F, 17.299999237060547F, 17.100000381469727F, 16.899999618530273F, 17.200000762939453F, 17.399999618530273F, 17.100000381469727F, 17.299999237060547F, 17.0F, 16.899999618530273F, 17.100000381469727F, 17.399999618530273F, 17.5F, 17.399999618530273F, 17.200000762939453F, 17.100000381469727F, 17.100000381469727F, 17.399999618530273F, 17.200000762939453F, 17.0F, 16.899999618530273F, 17.0F, 17.0F, 17.299999237060547F, 17.200000762939453F, 17.100000381469727F, 17.200000762939453F, 17.299999237060547F, 17.5F, 17.5F, 17.200000762939453F, 17.200000762939453F, 17.100000381469727F, 17.100000381469727F, 17.299999237060547F, 17.200000762939453F, 17.5F, 16.899999618530273F, 17.100000381469727F, 17.299999237060547F, 17.399999618530273F, 17.100000381469727F, 17.200000762939453F, 17.200000762939453F, 17.399999618530273F, 17.5F, 17.0F, 17.0F, 17.100000381469727F, 17.100000381469727F, 17.100000381469727F, 17.200000762939453F, 17.200000762939453F, 17.399999618530273F, 17.0F, 17.299999237060547F, 17.0F, 17.399999618530273F, 17.100000381469727F, 17.100000381469727F, 17.299999237060547F, 17.200000762939453F, 17.399999618530273F, 17.100000381469727F, 16.799999237060547F, 17.0F, 17.399999618530273F, 17.100000381469727F, 17.100000381469727F, 17.200000762939453F, 17.299999237060547F, 17.399999618530273F, 17.399999618530273F, 16.799999237060547F, 17.5F, 17.100000381469727F, 17.200000762939453F, 17.200000762939453F, 17.200000762939453F, 17.399999618530273F, 17.200000762939453F, 16.799999237060547F, 16.899999618530273F, 17.5F, 17.299999237060547F, 17.200000762939453F};
    	return ib;
    }
    
    private float[] getPower() {
    	float[] power = {2.2999999523162842F, 3.5999999046325684F, 4.0F, 5.6999998092651367F, 8.1000003814697266F, 6.6999998092651367F, 7.8000001907348633F, 8.8000001907348633F, 10.600000381469727F, 11.699999809265137F, 11.600000381469727F, 13.0F, 10.5F, 10.100000381469727F, 9.8000001907348633F, 10.899999618530273F, 11.899999618530273F, 11.800000190734863F, 11.699999809265137F, 9.6999998092651367F, 9.8999996185302734F, 10.0F, 10.699999809265137F, 12.199999809265137F, 11.800000190734863F, 11.0F, 9.0F, 11.800000190734863F, 11.0F, 11.5F, 12.399999618530273F, 11.600000381469727F, 10.600000381469727F, 9.1999998092651367F, 11.300000190734863F, 11.699999809265137F, 11.399999618530273F, 9.8999996185302734F, 10.5F, 10.600000381469727F, 11.800000190734863F, 10.699999809265137F, 11.300000190734863F, 12.0F, 9.8999996185302734F, 10.5F, 10.600000381469727F, 12.0F, 10.699999809265137F, 10.5F, 8.8000001907348633F, 10.100000381469727F, 11.100000381469727F, 10.5F, 11.699999809265137F, 10.199999809265137F, 10.100000381469727F, 9.6999998092651367F, 10.800000190734863F, 11.699999809265137F, 12.0F, 11.199999809265137F, 9.5F, 9.6999998092651367F, 10.300000190734863F, 11.0F, 12.0F, 11.899999618530273F, 10.600000381469727F, 9.0F, 10.399999618530273F, 10.800000190734863F, 11.300000190734863F, 12.399999618530273F, 10.899999618530273F, 10.199999809265137F, 8.8000001907348633F, 9.8999996185302734F, 11.199999809265137F, 11.300000190734863F, 9.3999996185302734F, 9.6999998092651367F, 10.800000190734863F, 9.3000001907348633F, 10.300000190734863F, 10.100000381469727F, 11.199999809265137F, 9.0F, 8.5F, 11.199999809265137F, 12.100000381469727F, 9.8999996185302734F, 8.0F, 8.5F, 6.9000000953674316F, 7.4000000953674316F, 6.3000001907348633F, 4.9000000953674316F, 4.1999998092651367F, 1.3999999761581421F, 1.1000000238418579F, 0.699999988079071F, 0.60000002384185791F, 0.699999988079071F, 1.5F, 1.3999999761581421F, 0.20000000298023224F, 1.0F, 0.800000011920929F, 0.40000000596046448F, 1.0F, 2.7999999523162842F, 3.0999999046325684F, 1.7000000476837158F, 1.2999999523162842F, 2.4000000953674316F, 1.2000000476837158F, 3.0999999046325684F, 2.0F, 2.4000000953674316F, 1.7999999523162842F, 1.1000000238418579F, 1.7000000476837158F, 3.2999999523162842F, 3.2999999523162842F, 1.5F, 0.60000002384185791F, 0.699999988079071F, 1.3999999761581421F, 2.5F, 2.4000000953674316F, 1.2999999523162842F, 0.89999997615814209F, 1.2000000476837158F, 2.7999999523162842F, 2.5F, 2.2999999523162842F, 0.800000011920929F, 1.5F, 1.7000000476837158F, 1.2999999523162842F, 2.9000000953674316F, 1.1000000238418579F, 0.5F, 1.3999999761581421F, 2.0999999046325684F, 3.0F, 2.5F, 1.2999999523162842F, 1.3999999761581421F, 1.8999999761581421F, 3.0F, 2.4000000953674316F, 1.8999999761581421F, 0.800000011920929F, 2.0999999046325684F, 2.0F, 1.8999999761581421F, 2.7000000476837158F, 1.2000000476837158F, 3.2999999523162842F, 1.8999999761581421F, 2.2000000476837158F, 3.2999999523162842F, 2.2000000476837158F, 1.7000000476837158F, 1.3999999761581421F, 1.7000000476837158F, 3.0999999046325684F, 2.4000000953674316F, 1.7999999523162842F, 0.800000011920929F, 1.8999999761581421F, 2.2999999523162842F, 2.0999999046325684F, 1.2999999523162842F, 0.800000011920929F, 3.2000000476837158F, 2.0F, 2.2999999523162842F, 0.60000002384185791F, 1.7999999523162842F, 1.7000000476837158F, 1.6000000238418579F, 1.5F, 3.2999999523162842F, 2.2000000476837158F, 2.0999999046325684F, 0.60000002384185791F, 1.8999999761581421F, 2.2000000476837158F, 2.2000000476837158F, 1.6000000238418579F, 0.699999988079071F, 2.5999999046325684F, 1.7999999523162842F, 2.5999999046325684F, 0.60000002384185791F, 1.3999999761581421F, 2.0999999046325684F};
    	return power;
    }
    private float[] getPowerFactor() {
    	float [] powerFactor = {0.17700000107288361F, 0.27700001001358032F, 0.30300000309944153F, 0.41999998688697815F, 0.55900001525878906F, 0.47299998998641968F, 0.52499997615814209F, 0.56999999284744263F, 0.64200001955032349F, 0.68199998140335083F, 0.67000001668930054F, 0.718999981880188F, 0.628000020980835F, 0.61500000953674316F, 0.60399997234344482F, 0.64999997615814209F, 0.68900001049041748F, 0.68500000238418579F, 0.671999990940094F, 0.597000002861023F, 0.609000027179718F, 0.61799997091293335F, 0.64200001955032349F, 0.70200002193450928F, 0.68400001525878906F, 0.64800000190734863F, 0.56499999761581421F, 0.68400001525878906F, 0.6600000262260437F, 0.67299997806549072F, 0.70200002193450928F, 0.671999990940094F, 0.63899999856948853F, 0.578000009059906F, 0.66200000047683716F, 0.6600000262260437F, 0.67299997806549072F, 0.60799998044967651F, 0.63099998235702515F, 0.63999998569488525F, 0.5910000205039978F, 0.640999972820282F, 0.66299998760223389F, 0.69599997997283936F, 0.6119999885559082F, 0.593999981880188F, 0.640999972820282F, 0.69199997186660767F, 0.64300000667572021F, 0.62699997425079346F, 0.5559999942779541F, 0.61799997091293335F, 0.66200000047683716F, 0.63400000333786011F, 0.68000000715255737F, 0.61699998378753662F, 0.61299997568130493F, 0.60199999809265137F, 0.64899998903274536F, 0.68199998140335083F, 0.69099998474121094F, 0.656000018119812F, 0.57899999618530273F, 0.59600001573562622F, 0.63300001621246338F, 0.65200001001358032F, 0.6940000057220459F, 0.68400001525878906F, 0.63200002908706665F, 0.56499999761581421F, 0.63200002908706665F, 0.652999997138977F, 0.66600000858306885F, 0.70899999141693115F, 0.65100002288818359F, 0.62999999523162842F, 0.56300002336502075F, 0.6119999885559082F, 0.6679999828338623F, 0.66699999570846558F, 0.58799999952316284F, 0.59899997711181641F, 0.65100002288818359F, 0.58600002527236938F, 0.63200002908706665F, 0.61599999666213989F, 0.66299998760223389F, 0.56999999284744263F, 0.54400002956390381F, 0.67000001668930054F, 0.70200002193450928F, 0.61900001764297485F, 0.52499997615814209F, 0.55699998140335083F, 0.47299998998641968F, 0.515999972820282F, 0.45199999213218689F, 0.3619999885559082F, 0.32100000977516174F, 0.1080000028014183F, 0.086999997496604919F, 0.061000000685453415F, 0.048000000417232513F, 0.059000000357627869F, 0.11699999868869782F, 0.11100000143051148F, 0.017000000923871994F, 0.0860000029206276F, 0.065999999642372131F, 0.037000000476837158F, 0.13600000739097595F, 0.21899999678134918F, 0.24500000476837158F, 0.12999999523162842F, 0.10499999672174454F, 0.18899999558925629F, 0.0949999988079071F, 0.2460000067949295F, 0.1550000011920929F, 0.19300000369548798F, 0.14300000667572022F, 0.086999997496604919F, 0.13699999451637268F, 0.26100000739097595F, 0.2630000114440918F, 0.12200000137090683F, 0.048999998718500137F, 0.054999999701976776F, 0.1120000034570694F, 0.20000000298023224F, 0.19099999964237213F, 0.10400000214576721F, 0.071000002324581146F, 0.096000000834465027F, 0.21899999678134918F, 0.19599999487400055F, 0.18500000238418579F, 0.064999997615814209F, 0.12200000137090683F, 0.1379999965429306F, 0.10599999874830246F, 0.22900000214576721F, 0.0860000029206276F, 0.041999999433755875F, 0.1080000028014183F, 0.1679999977350235F, 0.23399999737739563F, 0.19599999487400055F, 0.10000000149011612F, 0.10899999737739563F, 0.15199999511241913F, 0.23600000143051148F, 0.19300000369548798F, 0.15099999308586121F, 0.061000000685453415F, 0.164000004529953F, 0.15899999439716339F, 0.14800000190734863F, 0.21199999749660492F, 0.093999996781349182F, 0.26100000739097595F, 0.15099999308586121F, 0.17700000107288361F, 0.257999986410141F, 0.17100000381469727F, 0.13699999451637268F, 0.1120000034570694F, 0.13600000739097595F, 0.24199999868869782F, 0.18899999558925629F, 0.14499999582767487F, 0.061999998986721039F, 0.15000000596046448F, 0.18400000035762787F, 0.164000004529953F, 0.17299999296665192F, 0.064000003039836884F, 0.24899999797344208F, 0.15700000524520874F, 0.18500000238418579F, 0.23800000548362732F, 0.14499999582767487F, 0.13699999451637268F, 0.12800000607967377F, 0.11800000071525574F, 0.2630000114440918F, 0.17100000381469727F, 0.16500000655651093F, 0.048000000417232513F, 0.14900000393390656F, 0.17200000584125519F, 0.17299999296665192F, 0.12700000405311585F, 0.05299999937415123F, 0.2070000022649765F, 0.14599999785423279F, 0.2070000022649765F, 0.048999998718500137F, 0.11299999803304672F, 0.1679999977350235F};
    	return powerFactor;
    }
	
}
