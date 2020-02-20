package com.leyou.demo.userservice.instance;

import java.util.Date;

/**
 * @ClassName BasePojo
 * @Description: TODO
 * @Author 79440
 * @Date 2020/2/19
 * @Version V1.0
 **/
public class BasePojo {
    private Date createDate;
    private Date upDate;
    private String createBy;
    private String updateBy;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
