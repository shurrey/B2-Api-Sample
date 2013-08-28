/**
 * 
 */
package com.blackboard.developer.apisample.api;

/**
 * @author shurrey
 *
 */

import java.util.List;

import blackboard.base.IFactory;
import blackboard.data.course.Course;
import blackboard.data.user.User;
import blackboard.persist.Id;
import blackboard.platform.extension.util.ExtensionIFactory;

public interface B2ApiSample {
	
	String EXTENSION_POINT_MODULE = "com.blackboard.devloper.apisample";
	String EXTENSION_POINT = EXTENSION_POINT_MODULE + ".b2ApiSample";

	  public static final IFactory<B2ApiSample> Factory = 
	      ExtensionIFactory.getFactory( B2ApiSample.class, EXTENSION_POINT, true );
	
	// Get All Data
	List<Course> getCourseListForUser(Id userId);
	
	// Seed Data
	List<User> getRosterByCourseId(Id courseId);
	
}
