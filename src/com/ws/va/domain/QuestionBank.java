
package com.ws.va.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllQuestionBanks", query = "select myQuestionBank from QuestionBank myQuestionBank"),
		@NamedQuery(name = "findQuestionBankByAnswer", query = "select myQuestionBank from QuestionBank myQuestionBank where myQuestionBank.answer = ?1"),
		@NamedQuery(name = "findQuestionBankByAnswerContaining", query = "select myQuestionBank from QuestionBank myQuestionBank where myQuestionBank.answer like ?1"),
		@NamedQuery(name = "findQuestionBankByCatId", query = "select myQuestionBank from QuestionBank myQuestionBank where myQuestionBank.catId = ?1"),
		@NamedQuery(name = "findQuestionBankByPrimaryKey", query = "select myQuestionBank from QuestionBank myQuestionBank where myQuestionBank.questionId = ?1"),
		@NamedQuery(name = "findQuestionBankByQuestion", query = "select myQuestionBank from QuestionBank myQuestionBank where myQuestionBank.question = ?1"),
		@NamedQuery(name = "findQuestionBankByQuestionContaining", query = "select myQuestionBank from QuestionBank myQuestionBank where myQuestionBank.question like ?1"),
		@NamedQuery(name = "findQuestionBankByQuestionId", query = "select myQuestionBank from QuestionBank myQuestionBank where myQuestionBank.questionId = ?1"),
		@NamedQuery(name = "findQuestionBankByTopicId", query = "select myQuestionBank from QuestionBank myQuestionBank where myQuestionBank.topicId = ?1") })

@Table(schema = "APP", name = "QUESTION_BANK")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "VirtualAgentEngine/com/ws/va/domain", name = "QuestionBank")

public class QuestionBank implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "QUESTION_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer questionId;
	/**
	 */

	@Column(name = "TOPIC_ID")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer topicId;
	/**
	 */

	@Column(name = "QUESTION", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String question;
	/**
	 */

	@Column(name = "ANSWER", length = 100, nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String answer;
	/**
	 */

	@Column(name = "CAT_ID")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer catId;

	@Column(name = "AMBIGUITY_QUEST")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String ambiguityQuest;

	@Column(name = "VERIFY")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String verify;

	int numberOfRecordsReturned;
	
	Map<String, Integer> percentageData;

	public Map<String, Integer> getPercentageData() {
		percentageData = new HashMap<String, Integer>();
		return percentageData;
	}

	public void setPercentageData(String str, int value) {
		percentageData = new HashMap<String, Integer>();
		percentageData.put(str, value);
	}

	public int getNumberOfRecordsReturned() {
		return numberOfRecordsReturned;
	}

	public void setNumberOfRecordsReturned(int numberOfRecordsReturned) {
		this.numberOfRecordsReturned = numberOfRecordsReturned;
	}

	/**
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	/**
	 */
	public Integer getQuestionId() {
		return this.questionId;
	}

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
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 */
	public String getQuestion() {
		return this.question;
	}

	/**
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 */
	public String getAnswer() {
		return this.answer;
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

	public String getAmbiguity() {
		return ambiguityQuest;
	}

	public void setAmbiguity(String ambiguity) {
		this.ambiguityQuest = ambiguity;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	/**
	 */
	public QuestionBank() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(QuestionBank that) {
		setQuestionId(that.getQuestionId());
		setTopicId(that.getTopicId());
		setQuestion(that.getQuestion());
		setAnswer(that.getAnswer());
		setCatId(that.getCatId());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("questionId=[").append(questionId).append("] ");
		buffer.append("topicId=[").append(topicId).append("] ");
		buffer.append("question=[").append(question).append("] ");
		buffer.append("answer=[").append(answer).append("] ");
		buffer.append("catId=[").append(catId).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((questionId == null) ? 0 : questionId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof QuestionBank))
			return false;
		QuestionBank equalCheck = (QuestionBank) obj;
		if ((questionId == null && equalCheck.questionId != null) || (questionId != null && equalCheck.questionId == null))
			return false;
		if (questionId != null && !questionId.equals(equalCheck.questionId))
			return false;
		return true;
	}
}
