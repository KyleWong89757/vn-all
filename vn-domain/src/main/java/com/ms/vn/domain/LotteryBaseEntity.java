package com.ms.vn.domain;

import java.util.Date;

/**
 * @描述:
 * @author Andy
 * @version 1.0.0
 * @创建时间: 2016年12月3日 下午12:07:14
 */
public class LotteryBaseEntity
{
    private Long id;

    private String preDrawCode;

    private Integer drawCount;

    private Date preDrawDate;

    private Date preDrawTime;

    private Date drawTime;

    private Long preDrawIssue;

    private Long drawIssue;

    private int enable = 0;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getPreDrawCode()
    {
        return preDrawCode;
    }

    public void setPreDrawCode(String preDrawCode)
    {
        this.preDrawCode = preDrawCode;
    }

    public Integer getDrawCount()
    {
        return drawCount;
    }

    public void setDrawCount(Integer drawCount)
    {
        this.drawCount = drawCount;
    }

    public Long getPreDrawIssue()
    {
        return preDrawIssue;
    }

    public void setPreDrawIssue(Long preDrawIssue)
    {
        this.preDrawIssue = preDrawIssue;
    }

    public Long getDrawIssue()
    {
        return drawIssue;
    }

    public void setDrawIssue(Long drawIssue)
    {
        this.drawIssue = drawIssue;
    }

    public Date getPreDrawDate()
    {
        return preDrawDate;
    }

    public void setPreDrawDate(Date preDrawDate)
    {
        this.preDrawDate = preDrawDate;
    }

    public Date getPreDrawTime()
    {
        return preDrawTime;
    }

    public void setPreDrawTime(Date preDrawTime)
    {
        this.preDrawTime = preDrawTime;
    }

    public Date getDrawTime()
    {
        return drawTime;
    }

    public void setDrawTime(Date drawTime)
    {
        this.drawTime = drawTime;
    }

    public int getEnable()
    {
        return enable;
    }

    public void setEnable(int enable)
    {
        this.enable = enable;
    }

    @Override
    public String toString()
    {
        return "LotteryBaseEntity [id=" + id + ", preDrawCode=" + preDrawCode + ", drawCount=" + drawCount
                + ", preDrawDate=" + preDrawDate + ", preDrawTime=" + preDrawTime + ", drawTime=" + drawTime
                + ", preDrawIssue=" + preDrawIssue + ", drawIssue=" + drawIssue + ", enable=" + enable + "]";
    }

}
