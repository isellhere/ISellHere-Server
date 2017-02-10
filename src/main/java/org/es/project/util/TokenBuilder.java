package org.es.project.util;

import org.es.project.models.User;

public interface TokenBuilder {
	
	public String build(User user);

}
