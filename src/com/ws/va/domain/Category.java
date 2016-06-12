
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
		@NamedQuery(name = "findAllCategorys", query = "select myCategory from Category myCategory"),
		@NamedQuery(name = "findCategoryByCatId", query = "select myCategory from Category myCategory where myCategory.catId = ?1"),
		@NamedQuery(name = "findCategoryByPrimaryKey", query = "select myCategory from Category myCategory where myCategory.catId = ?1") })

@Table(schema = "APP", name = "CATEGORY")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "VirtualAgentEngine/com/ws/va/domain", name = "Category")

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "CAT_ID", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer catId;

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
	public Category() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Category that) {
		setCatId(that.getCatId());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("catId=[").append(catId).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((catId == null) ? 0 : catId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Category))
			return false;
		Category equalCheck = (Category) obj;
		if ((catId == null && equalCheck.catId != null) || (catId != null && equalCheck.catId == null))
			return false;
		if (catId != null && !catId.equals(equalCheck.catId))
			return false;
		return true;
	}
}
