package com.lhx.cephfs.commons.domain;

import javax.persistence.*;

@Table(name = "node")
public class Node {
    /**
     * 节点ID
     */
    @Id
    @Column(name = "nodeId")
    private Integer nodeid;

    @Column(name = "nodeName")
    private String nodename;

    @Column(name = "nodeIp")
    private String nodeip;

    @Column(name = "isAdmin")
    private Integer isadmin;

    /**
     * 获取节点ID
     *
     * @return nodeId - 节点ID
     */
    public Integer getNodeid() {
        return nodeid;
    }

    /**
     * 设置节点ID
     *
     * @param nodeid 节点ID
     */
    public void setNodeid(Integer nodeid) {
        this.nodeid = nodeid;
    }

    /**
     * @return nodeName
     */
    public String getNodename() {
        return nodename;
    }

    /**
     * @param nodename
     */
    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    /**
     * @return nodeIp
     */
    public String getNodeip() {
        return nodeip;
    }

    /**
     * @param nodeip
     */
    public void setNodeip(String nodeip) {
        this.nodeip = nodeip;
    }

    /**
     * @return isAdmin
     */
    public Integer getIsadmin() {
        return isadmin;
    }

    /**
     * @param isadmin
     */
    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }
}