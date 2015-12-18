package com.bizhi.module;

/**
 * Created by Administrator on 2015/11/28 0028.
 */
public class BizhiData {

    public static final int TYPE_SUB_TITLE = 0;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_IMAGE_LINE = 2;

    public String imgUrl;
    public String style;
    public String name;
    public boolean like;
    public int downCount;
    public int type;

    public String content;

    public BizhiData(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BizhiData(String style, String imgUrl) {
        this.style = style;
        this.imgUrl = imgUrl;
    }

    public BizhiData(int type, String style, String imgUrl) {
        this.style = style;
        this.imgUrl = imgUrl;
        this.type = type;
    }

    public BizhiData(int type, String style, String content, String imgUrl) {
        this.style = style;
        this.imgUrl = imgUrl;
        this.type = type;
        this.content = content;
        this.name = style;
    }
}
