package com.jsg.dzfbhealthcard.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.util.Date;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark MD5加密工具类
 * @since 2019/8/29 9:51
 */
@Slf4j
public class MD5Util {

        private static final String hexDigIts[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

        /**
         * MD5加密
         * @param origin 字符
         * @param charsetname 编码
         * @return
         */
        public static String MD5Encode(String origin, String charsetname){
            String resultString = null;
            try{
                log.info("【签名内容】：" + origin);
                log.info("【MD5正在加密】：.....");
                resultString = new String(origin);
                MessageDigest md = MessageDigest.getInstance("MD5");
                if(null == charsetname || "".equals(charsetname)){
                    resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
                }else{
                    resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            log.info("【生成签名】：" + resultString);
            return resultString;
        }


        public static String byteArrayToHexString(byte b[]){
            StringBuffer resultSb = new StringBuffer();
            for(int i = 0; i < b.length; i++){
                resultSb.append(byteToHexString(b[i]));
            }
            return resultSb.toString();
        }

        public static String byteToHexString(byte b){
            int n = b;
            if(n < 0){
                n += 256;
            }
            int d1 = n / 16;
            int d2 = n % 16;
            return hexDigIts[d1] + hexDigIts[d2];
        }


    public static void main(String[] args) {
            try{
                String decBizContentStr = AESUtil.decrypt("7C6302F73F6A395F8C5F4E82E6E69829F99ABCCD4E06247056919115A50B64870389CEFF4B9F4B01F1726600C45709A800EA568C692132E86CD7F4A9D04538F031AD7F363369E7A0704DE9210FF5B0CDD47F8E58979B2DFE8A9E2FB1E76B0859A1B451A486CB2A9F518B6D3027F5E947B287F2539C0493F9C5C13506714106C86B95D659EF9DACE96EABD88758AB823728EC80996B345786F5B22DA12464708D7E2892B759BB52C39B3E2B0A809D8BB7588AE89EE319F9712AF23D69CB89AB230575AF7612A3070C2C0D78E4B5B50EBC2072726CB04CE2DD37BEFEA92A1558F97E8AD890C46DC23DC82C09BEE30147DD85198D4CDC09C307033217354FEE2A1A86A1CD3DBB6D41701CC26518510FD151A646780F4C54967BB6508C88EC678D28033E9F7A33C5C88C1B7B2A2DE65E9C1703283979A5C7DDD783FAA521AE5ED9083C1526E1C59428C10A388805D58385078BBD89C0F3ABB8F25E0565A315D3CA7F4A4404BA4DAE7A8F5C28E4BDEDEAFF3D910AD32D1242F638509F0DEE65EC39D60E57755DF529CD9A61E5224DB7EEC952568DDD573D2FED2E844115C61EC549BC487F2B156A279E3159C0DA900BD02F9CE1E48A5FA50773E533FFB41BF8B4687A412C58FA28202DC213674BFFE9A6902AAED9CDB33C0F446F97672867D26369669966D52ADBED88A2C44087AE524F1A5B8F4213549F45756885D3B31C72B3D9943DF9E508CA920A326BE1CB154062957DD66A01CD34EDA872FA3229F437DA57306845BC2B6D860540F8108E8A1332958FB99CE31255DE18E40416B1CE8FDF66454388EDD86CEEECAE1EB795B762812B8C21ABD8FA623CDB9A15FB3B9926E08C3B2198E826606461807EDA18E9E0103F14ADC56A93EB93D9B2CC1F56B028203FC5ACE7A7E9186949B0F22BEE557DC1CD1D410BE78C8B571826E10EBBE070342F196E704AC1B0829DB317FD71D474BBD2EF3BEBF14BA477CB10B818EAC08E58449C5F1F958CC3E9DDCB31EC8329402D8BC456C5C16269E57CE43ED5D8774F80F90098F6A33C07C7F168D62E15E50D6392838D3BD499ACDE8821399BDBA34D6D5DD230E8ABAA116613E867F25A6D2F5C33C226F66BE5060D1DB38BB0A277CEF791A064D66B9F4FFED6291E5224433B47AE9276B471F2FD655361F9C13F0AC4ECC478","D7A081E7FD4C10BE");
                System.out.println(decBizContentStr);
            }catch (Exception e){

            }
    }

}
