
package com.ws.va.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTopics", query = "select myTopic from Topic myTopic"),
		@NamedQuery(name = "findTopicByCatId", query = "select myTopic from Topic myTopic where myTopic.catId = ?1"),
		@NamedQuery(name = "findTopicByPrimaryKey", query = "select myTopic from Topic myTopic where myTopic.topicId = ?1"),
		@NamedQuery(name = "findTopicByTopicId", query = "select myTopic from Topic myTopic where myTopic.topicId = ?1"),
		@NamedQuery(name = "findTopicByTopicName", query = "select myTopic from Topic myTopic where myTopic.topicName = ?1"),
		@NamedQuery(name = "findTopicByTopicNameContaining", query = "select myTopic from Topic myTopic where myTopic.topicName like ?1") })

@Table(schema = "APP", name = "TOPIC")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "VirtualAgentEngine/com/ws/va/domain", name = "Topic")

public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "TOPIC_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer topicId;
	/**
	 */

	@Column(name = "CAT_ID")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer catId;
	/**
	 */

	@Column(name = "TOPIC_NAME", length = 30)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String topicName;

	/**
	 */
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	/**
	 */
	public Integer getTopicId() {
		return this.topicId;
	}

	/**
	 */
	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	/**
	 */
	public Integer getCatId() {
		return this.catId;
	}

	/**
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	/**
	 */
	public String getTopicName() {
		return this.topicName;
	}

	/**
	 */
	public Topic() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Topic that) {
		setTopicId(that.getTopicId());
		setCatId(that.getCatId());
		setTopicName(that.getTopicName());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("topicId=[").append(topicId).append("] ");
		buffer.append("catId=[").append(catId).append("] ");
		buffer.append("topicName=[").append(topicName).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((topicId == null) ? 0 : topicId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Topic))
			return false;
		Topic equalCheck = (Topic) obj;
		if ((topicId == null && equalCheck.topicId != null) || (topicId != null && equalCheck.topicId == null))
			return false;
		if (topicId != null && !topicId.equals(equalCheck.topicId))
			return false;
		return true;
	}
}
