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
	
	String EXTENSION_POINT_MODULE = "com.blackboard.developer.apisample.api";
	String EXTENSION_POINT = EXTENSION_POINT_MODULE + ".b2ApiSample";

	  public static final IFactory<B2ApiSample> Factory = 
	      ExtensionIFactory.getFactory( B2ApiSample.class, EXTENSION_POINT, true );
	
	// Get All Courses For User
	public List<Course> getCourseListForUser(Id userId);
	
	// Get All User For Course
	public List<User> getRosterByCourseId(Id courseId);
	
}
