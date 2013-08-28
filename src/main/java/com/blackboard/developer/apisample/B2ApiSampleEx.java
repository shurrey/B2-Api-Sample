/**
 * 
 */
package com.blackboard.developer.apisample;

/**
 * @author shurrey
 *
 */

import java.util.List;

import blackboard.data.course.Course;
import blackboard.data.user.User;
import blackboard.persist.Id;

public interface B2ApiSampleEx {
	
	// Get All Data
	List<Course> getCourseListForUser(Id userId);
	
	// Seed Data
	List<User> getRosterByCourseId(Id courseId);
	
}
