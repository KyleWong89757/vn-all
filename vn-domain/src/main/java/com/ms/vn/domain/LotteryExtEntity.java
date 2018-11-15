package com.ms.vn.domain;

import java.util.Date;

/**
 * @描述:
 * @author Kyle
 * @version 1.0.0
 * @创建时间: 2018年11月6日17:58:27
 */
public class LotteryExtEntity extends LotteryBaseEntity
{
    private Date createTime;

    private Date updateTime;

    private Date prepareDrawTime;

    private int drawStatus;

    private int alarmStatus;

    private Date overDrawTime;

    private int nextDrawIssueStatus;

    private String codeSource;

    private int ignoreAnalysisFlag;

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getCodeSource()
    {
        return codeSource;
    }

    public void setCodeSource(String codeSource)
    {
        this.codeSource = codeSource;
    }

    public int getDrawStatus()
    {
        return drawStatus;
    }

    public void setDrawStatus(int drawStatus)
    {
        this.drawStatus = drawStatus;
    }

    public Date getPrepareDrawTime()
    {
        return prepareDrawTime;
    }

    public void setPrepareDrawTime(Date prepareDrawTime)
    {
        this.prepareDrawTime = prepareDrawTime;
    }

    public Date getOverDrawTime()
    {
        return overDrawTime;
    }

    public void setOverDrawTime(Date overDrawTime)
    {
        this.overDrawTime = overDrawTime;
    }

    public int getNextDrawIssueStatus()
    {
        return nextDrawIssueStatus;
    }

    public void setNextDrawIssueStatus(int nextDrawIssueStatus)
    {
        this.nextDrawIssueStatus = nextDrawIssueStatus;
    }

    public int getAlarmStatus()
    {
        return alarmStatus;
    }

    public void setAlarmStatus(int alarmStatus)
    {
        this.alarmStatus = alarmStatus;
    }

    public int getIgnoreAnalysisFlag()
    {
        return ignoreAnalysisFlag;
    }

    public void setIgnoreAnalysisFlag(int ignoreAnalysisFlag)
    {
        this.ignoreAnalysisFlag = ignoreAnalysisFlag;
    }

    @Override
    public String toString()
    {
        return "LotteryExtEntity [id=" + this.getId() + ", preDrawCode=" + getPreDrawCode() + ", drawCount="
                + getDrawCount() + ", preDrawDate=" + getPreDrawDate() + ", preDrawTime=" + getPreDrawTime()
                + ", drawTime=" + getDrawTime() + ", preDrawIssue=" + getPreDrawIssue() + ", drawIssue="
                + getDrawIssue() + ", enable=" + getEnable() + ",createTime=" + createTime + ", updateTime="
                + updateTime + ", prepareDrawTime=" + prepareDrawTime + ", drawStatus=" + drawStatus
                + ", overDrawTime=" + overDrawTime + ", nextDrawIssueStatus=" + nextDrawIssueStatus + ", codeSource="
                + codeSource + ",ignoreAnalysisFlag=" + ignoreAnalysisFlag + "]";
    }
}
