/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author xhunt
 */
public class DataUtil {
    public static String md5(String str) throws NoSuchAlgorithmException{
		String result = "";
		MessageDigest digest;
                digest = MessageDigest.getInstance("MD5");
                digest.update(str.getBytes());
                BigInteger bigInteger = new BigInteger(1,digest.digest());
                result = bigInteger.toString(16);
		return result;
	}
}
