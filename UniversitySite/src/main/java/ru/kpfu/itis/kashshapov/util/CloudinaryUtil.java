package ru.kpfu.itis.kashshapov.util;

import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryUtil {
    private static Cloudinary cloudinary;

    public static Cloudinary getInstance() {
        if (cloudinary == null) {
            Map configMap = new HashMap();
            configMap.put("cloud_name", "dr53on9mb");
            configMap.put("api_key", "375237293798666");
            configMap.put("api_secret", "RqjTMfbSjSvQ6D7CJHBkUHmjQNQ");
            cloudinary = new Cloudinary(configMap);
        }
        return cloudinary;
    }
}
