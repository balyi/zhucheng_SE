package com.chateau.pojo;

/**
 * Created by tedu on 2017/11/25.
 */

public class Wine {
    private String wineId;
    private Chateau chateau; // 用来获取酒庄id
    private String wineName;
    private String year;  //年份
    private Double price;
    private Integer pnum; //库存
    private String imgurl; //图片源
    private String area; // 产地
    private String alcohol; // 度数
    private String type; // 红葡萄酒、白葡萄酒
    private String time; // 放入酒窖时间
    private String remark; // 酒单介绍
    private String check;
    private Integer date; //预定的年份

  /*// 只要id相同, hashCode的值肯定相同
    public int hashCode() {
        return wineId == null ? 0 : wineId.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // 判断obj是否为Product
        if (!(obj instanceof Wine)) {
            // obj不是Product类的对象
            return false;
        }
        // 说明obj是Product类创建的对象
        Wine other = (Wine) obj;
        if (wineId != null && wineId.equals(other.getWineId())) {
            // 说明两个对象id相同
            return true;
        }
        return false;
    }*/
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (obj instanceof Wine){
        Wine w = (Wine)obj;
        if (w.wineId.equals(this.wineId)&&w.check.equals(this.check)){
            return true;
        }
    }
    return false;
}

    @Override
    public int hashCode() {
        StringBuilder sb=new StringBuilder(wineId);
        sb.append(check);
        String str=sb.toString();
        return str == null ? 0 : str.hashCode();
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getWineId() {
        return wineId;
    }

    public void setWineId(String wineId) {
        this.wineId = wineId;
    }

    public Chateau getChateau() {
        return chateau;
    }

    public void setChateau(Chateau chateau) {
        this.chateau = chateau;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "wineId='" + wineId + '\'' +
                ", chateau=" + chateau +
                ", wineName='" + wineName + '\'' +
                ", year='" + year + '\'' +
                ", price=" + price +
                ", pnum=" + pnum +
                ", imgurl='" + imgurl + '\'' +
                ", area='" + area + '\'' +
                ", alcohol='" + alcohol + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
