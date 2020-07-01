package com.jsg.dzfbhealthcard.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 类描述
 * @since 2019/11/5 11:32
 */
public class StringXUtils {
    /**
     * 首字母大写
     *
     * @param string
     * @return
     */
    public static String toUpperCase4Index(String string) {
        if (StringUtils.isBlank(string))
            return null;
        string = string.trim();
        char[] names = string.toCharArray();
        names[0] = toUpperCase(names[0]);
        return String.valueOf(names);
    }

    /**
     * 字符转成大写
     *
     * @param chars
     * @return
     */
    public static char toUpperCase(char chars) {
        if (97 <= chars && chars <= 122) {
            chars ^= 32;
        }
        return chars;
    }

    /**
     * 判断是否为空或仅包含空格的字符串 <br/>
     *
     * @param str
     *            判断字符串
     * @param message
     *            异常抛出消息
     * @author pengyunbo
     * @Creating_Time 2017年9月18日 上午9:58:30
     */
    public static void notBlank(String str, String message) {
//        if (StringUtils.isBlank(str)) {
//            throw MessageStatusException.instance(1001, message);
//        }
    }

    /**
     * 转换路径中反斜杠为正斜杠，并且删除相邻多余正斜杠 <br/>
     *
     * @param path
     *            待处理路径
     * @author pengyunbo
     * @return String 已处理路径
     * @Creating_Time 2017年9月26日 下午7:10:32
     */
    public static String clearPathSlash(String path) {
        if (StringUtils.isBlank(path))
            return null;
        path = path.replaceAll("\\\\", "/").replaceAll("/{2,}", "/");
        return path;
    }

    /**
     * 为值添加数据库右模糊查询符号 <br/>
     * ：推荐使用 <br/>
     *
     * @param value
     * @author pengyunbo
     * @return String
     * @Creating_Time 2017年12月7日 上午10:00:01
     */
    public static String addRightLike(String value) {
        if (StringUtils.isBlank(value))
            return null;
        StringBuilder builder = new StringBuilder(value.trim());
        while (builder.indexOf("%") == 0)
            builder.deleteCharAt(0);
        // 添加模糊查询符号
        if (builder.lastIndexOf("%") != (builder.length() - 1)) {
            builder.append('%');
        }
        return builder.toString();
    }

    /**
     * 为值添加数据库左模糊查询符号 <br/>
     * ：不推荐使用 <br/>
     *
     * @param value
     * @author pengyunbo
     * @return String
     * @Creating_Time 2017年12月7日 上午10:00:01
     */
    public static String addLeftLike(String value) {
        if (StringUtils.isBlank(value))
            return null;
        StringBuilder builder = new StringBuilder(value.trim());
        int length = builder.length();
        while (builder.lastIndexOf("%") == (length - 1)) {
            builder.deleteCharAt(length - 1);
            length--;
        }
        // 添加模糊查询符号
        if (builder.indexOf("%") != 0) {
            builder.insert(0, "%");
        }
        return builder.toString();
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return 16进制
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将字符串原文转为16进制字符串 <br>
     *
     * @param data
     *            字符串原文
     * @author pengyunbo
     * @return String 16进制字符串
     * @Creating_Time 2018年11月27日 下午5:01:33
     */
    public static String parseString2HexStr(String data) {
        byte[] bytes = data.getBytes();
        return parseByte2HexStr(bytes);
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return byte[] 二进制
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    private final static char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    /***
     * 'byte[]' to 'String'. <br>
     * 数据加密与解密使用 <br>
     *
     * @param d
     *            字节数组
     * @param s
     *            偏移位
     * @param n
     *            长度
     * @return 字节数组转换后字符串
     */
    public static String toHexStringR(byte[] d, int s, int n) {
        final char[] ret = new char[n * 2];
        int x = 0;
        for (int i = s; i < s + n; i++) {
            final byte v = d[i];
            ret[x++] = HEX[0x0F & (v >> 4)];
            ret[x++] = HEX[0x0F & v];
        }
        return new String(ret);
    }

    /**
     * 删除重复空格，替换换行与回车为空格 <br>
     *
     * @param data
     *            待处理数据
     * @author pengyunbo
     * @return String
     * @Creating_Time 2018年12月4日 上午10:25:49
     */
    public static String deleteDoubleBlank(String data) {
        if (StringUtils.isNotBlank(data)) {
            String temp = data;
            // 清除换行符
            temp = temp.replaceAll("\n{1,}", " ");
            // 清除回车符
            temp = temp.replaceAll("\r{1,}", " ");
            // 清除多余制表符“\t”
            temp = temp.replaceAll("\t{2,}", "\t");
            // 清除多余“ ”
            temp = temp.replaceAll(" {2,}", " ");
            return temp;
        }
        return null;
    }

    /**
     * 大写字母转小写，并添加分割线 <br>
     *
     * @param source
     *            原字符串
     * @param split
     *            替换分割符
     * @author pengyunbo
     * @return String 替换后字符
     * @Creating_Time 2019年1月17日 下午5:48:57
     */
    public static String upperCaseToSplitLower(String source, String split) {
        if (StringUtils.isNotBlank(source)) {
            if (StringUtils.isBlank(split)) {
                // 默认下划线
                split = "_";
            }
            char[] chars = source.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                char charnow = chars[i];
                if (Character.isUpperCase(charnow) && i != 0) {
                    builder.append(split);
                    charnow = Character.toLowerCase(charnow);
                }
                builder.append(charnow);
            }
            return builder.toString();
        }
        return "";
    }

    /**
     * 对指定数据，隐藏除首字符外的其它字符 <br>
     *
     * @param source
     *            隐藏数据源
     * @param padChar
     *            替换字符值，默认*
     * @author pengyunbo
     * @return String
     * @Creating_Time 2019年8月7日 下午2:34:04
     */
    public static String padExceptFirst(String source, String padChar) {
        if (StringUtils.isNotBlank(source)) {
            String firstChar = source.substring(0, 1);
            int len = source.length() - 1;
            if (len < 1) {
                len = 1;
            }
            if (StringUtils.isBlank(padChar))
                padChar = "*";
            return StringUtils.rightPad(firstChar, len, padChar);
        }
        return source;
    }

    /**
     * 对指定数据，隐藏除结尾字符外的其它字符<br>
     *
     * @param source
     *            隐藏数据源
     * @param padChar
     *            替换字符值，默认*
     * @author pengyunbo
     * @return String
     * @Creating_Time 2019年8月7日 下午2:40:46
     */
    public static String padExceptEnd(String source, String padChar) {
        if (StringUtils.isNotBlank(source)) {
            String endChar = source.substring(source.length() - 1);
            int len = source.length() - 1;
            if (len < 1) {
                len = 1;
            }
            if (StringUtils.isBlank(padChar))
                padChar = "*";
            return StringUtils.leftPad(endChar, len, padChar);
        }
        return source;
    }

    /**
     * 对指定数据，隐藏除首字符与结尾字符外的其它字符<br>
     *
     * @param source
     *            隐藏数据源
     * @param padChar
     *            替换字符值，默认*
     * @author pengyunbo
     * @return String
     * @Creating_Time 2019年8月7日 下午2:41:12
     */
    public static String padExceptFirstAndEnd(String source, String padChar) {
        if (StringUtils.isNotBlank(source)) {
            String firstChar = source.substring(0, 1);
            int length = source.length();
            if (length < 3) {
                return padExceptFirst(source, padChar);
            }
            String endChar = source.substring(source.length() - 1);
            int len = length - 1;
            if (StringUtils.isBlank(padChar))
                padChar = "*";
            return StringUtils.rightPad(firstChar, len, padChar) + endChar;
        }
        return source;
    }
}
