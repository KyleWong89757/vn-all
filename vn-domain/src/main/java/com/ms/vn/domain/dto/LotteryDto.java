package com.ms.vn.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @描述:
 * @author smith
 * @version 1.0.0
 * @创建时间: 2016年11月2日 下午3:49:51
 */
public class LotteryDto implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer drawCount;// 日开奖期数

    private Long preDrawIssue;// 已开奖期数

    private Date preDrawTime;// 已开奖时间

    private Date preDrawDate;// 已开奖日期

    private String preDrawCode;// 已开奖号码

    private Long drawIssue;// 当前开奖期数

    private Date drawTime;// 当前开奖时间

    private String codeSource;// 数据来源

    public Date getPreDrawTime()
    {
        return preDrawTime;
    }

    public void setPreDrawTime(Date preDrawTime)
    {
        this.preDrawTime = preDrawTime;
    }

    public Date getPreDrawDate()
    {
        return preDrawDate;
    }

    public void setPreDrawDate(Date preDrawDate)
    {
        this.preDrawDate = preDrawDate;
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

    public Date getDrawTime()
    {
        return drawTime;
    }

    public void setDrawTime(Date drawTime)
    {
        this.drawTime = drawTime;
    }

    public String getCodeSource()
    {
        return codeSource;
    }

    public void setCodeSource(String codeSource)
    {
        this.codeSource = codeSource;
    }

    @Override
    public String toString()
    {
        return "LotteryDto [drawCount=" + drawCount + ", preDrawIssue=" + preDrawIssue + ", preDrawTime=" + preDrawTime
                + ", preDrawCode=" + preDrawCode + ", drawIssue=" + drawIssue + ", drawTime=" + drawTime
                + ", codeSource=" + codeSource + "]";
    }

}
