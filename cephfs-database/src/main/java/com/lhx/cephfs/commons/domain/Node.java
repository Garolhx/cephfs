package com.lhx.cephfs.commons.domain;

import javax.persistence.*;

@Table(name = "cephfs..node")
public class Node {
    /**
     * 节点ID
     */
    @Id
    @Column(name = "node_id")
    private Integer nodeId;

    @Column(name = "node_name")
    private String nodeName;

    @Column(name = "node_ip")
    private String nodeIp;

    @Column(name = "is_admin")
    private Integer isAdmin;

    /**
     * 获取节点ID
     *
     * @return node_id - 节点ID
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     * 设置节点ID
     *
     * @param nodeId 节点ID
     */
    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return node_name
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * @param nodeName
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * @return node_ip
     */
    public String getNodeIp() {
        return nodeIp;
    }

    /**
     * @param nodeIp
     */
    public void setNodeIp(String nodeIp) {
        this.nodeIp = nodeIp;
    }

    /**
     * @return is_admin
     */
    public Integer getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin
     */
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
}