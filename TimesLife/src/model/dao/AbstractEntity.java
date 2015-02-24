package model.dao;

import java.io.Serializable;

import javax.persistence.Entity;

public abstract class AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) 
			return true;
		if(obj == null) 
			return false;
		if(getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if(getId() == null) {
			if(other.getId() != null)
				return false;
		} else if(!getId().equals(other.getId()))
			return false;
		return true;
	}
	
	public abstract Long getId();
	
	
}
