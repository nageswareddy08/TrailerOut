package com.trailer.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoID {

	
	/*  
     * URL's for getting the image using VID.
	 * 
	 * http://img.youtube.com/vi/NSMXka6ZKbM/0.jpg or
	 * http://img.youtube.com/vi/THE-VIDEO-ID/default.jpg � full size thumb
	 * http://img.youtube.com/vi/THE-VIDEO-ID/mqdefault.jpg � medium default
	 * http://img.youtube.com/vi/THE-VIDEO-ID/maxresdefault.jpg � high res
	 * http://img.youtube.com/vi/THE-VIDEO-ID/1.jpg � small thumb
	 * http://img.youtube.com/vi/THE-VIDEO-ID/2.jpg � small thumb
	 * http://img.youtube.com/vi/THE-VIDEO-ID/3.jpg � small thumb
	 * 
	 */

    public static String getVid(String iFrameUrl) {

        String vid = "";

        String regex = ".*embed/(.*)\" frame.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(iFrameUrl);

        if (matcher.matches()) {
            System.out.println("Match Found");
            vid = matcher.group(1);
        }

        return vid;
    }

    public static void main(String[] args) {

        // sample iframe url
        String iFrameUrl = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/NSMXka6ZKbM\" frameborder=\"0\" allowfullscreen></iframe>";
        String vid = getVid(iFrameUrl);
        System.out.println("VID = " + vid);


    }

}
