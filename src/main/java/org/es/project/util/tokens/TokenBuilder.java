package org.es.project.util.tokens;

import org.es.project.models.User;

public interface TokenBuilder {
	
	public String build(User user);

}
