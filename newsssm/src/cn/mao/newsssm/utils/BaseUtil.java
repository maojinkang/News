package cn.mao.newsssm.utils;

import java.io.PrintWriter;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

public class BaseUtil {
	public static String lrwCode(String password, String salt) {
		if (salt == "") {
			salt = "abcdefghijklmnopqrstuvwx";
		}
		return new Sha256Hash(password, salt, 1024).toBase64();
	}

	public static void outPrint(HttpServletResponse response, String data) {
		String encoding = "UTF-8";
		String contentType = "application/json;charset=UTF-8";

		response.setContentType(contentType);
		response.setCharacterEncoding(encoding);
		try {
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private static Gson gson = new Gson();
	
	public static boolean isNull(String str) {
		if (str != null && !str.trim().equals("")) {
			return false;
		} else {
			return true;
		}	
	}
	
	public static String toJson(Object src) {
		if (src == null) {
			return gson.toJson(JsonNull.INSTANCE);
		}
		return gson.toJson(src);
	}

	public static <T> Object fromJson(String json, Class<T> classOfT) {
		return gson.fromJson(json, (Type) classOfT);
	}

	public static Object fromJson(String json, Type typeOfT) {
		return gson.fromJson(json, typeOfT);
	}
}
