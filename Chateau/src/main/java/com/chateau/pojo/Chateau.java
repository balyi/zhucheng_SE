package com.chateau.pojo;

/**
 * Created by tedu on 2017/11/26.
 */
public class Chateau {
    private String chateauId;
    private User user;
    private String chateauName; //酒庄名称
    private String address; //酒庄地址
    private String level;// '超一级酒庄；一级酒庄；二级酒庄；三级酒庄；四级酒庄',
    private Integer reserveNum;//酒预定数量
    private String remark; //酒庄说明
    private String imgurl; //图片
    private String createTime;//酒庄创建时间
    private double area;//葡萄园面积
    private String output;// 年产量
    private String mostlyType;// 主要葡萄品种
    private String otherType;// 其他葡萄品种
    private String proportion;// 红葡萄比例


    public String getChateauId() {
        return chateauId;
    }

    public void setChateauId(String chateauId) {
        this.chateauId = chateauId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getChateauName() {
        return chateauName;
    }

    public void setChateauName(String chateauName) {
        this.chateauName = chateauName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(Integer reserveNum) {
        this.reserveNum = reserveNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getMostlyType() {
        return mostlyType;
    }

    public void setMostlyType(String mostlyType) {
        this.mostlyType = mostlyType;
    }

    public String getOtherType() {
        return otherType;
    }

    public void setOtherType(String otherType) {
        this.otherType = otherType;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    @Override
    public String toString() {
        return "Chateau{" +
                "chateauId='" + chateauId + '\'' +
                ", user=" + user +
                ", chateauName='" + chateauName + '\'' +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                ", reserveNum=" + reserveNum +
                ", remark='" + remark + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", createTime='" + createTime + '\'' +
                ", area=" + area +
                ", output='" + output + '\'' +
                ", mostlyType='" + mostlyType + '\'' +
                ", otherType='" + otherType + '\'' +
                ", proportion='" + proportion + '\'' +
                '}';
    }
}
