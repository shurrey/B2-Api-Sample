package com.blackboard.developer.apisample.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import blackboard.data.course.Course;
import blackboard.data.course.CourseMembership;
import blackboard.data.user.User;
import blackboard.persist.Id;
import blackboard.persist.PersistenceException;
import blackboard.persist.course.CourseDbLoader;
import blackboard.persist.course.CourseMembershipDbLoader;
import blackboard.persist.user.UserDbLoader;
import com.blackboard.developer.apisample.api.*;

public class B2ApiSampleImpl implements B2ApiSample {

	@Override
	public List<Course> getCourseListForUser(Id userId) {
		List<Course> courseList = new ArrayList<Course>();
		
		try {
			List<CourseMembership> cmList = CourseMembershipDbLoader.Default.getInstance().loadByUserId(userId);
			ListIterator<CourseMembership> cmIt = cmList.listIterator();
			
			while (cmIt.hasNext()) {
				CourseMembership curCm = cmIt.next();
				Course course = CourseDbLoader.Default.getInstance().loadById(curCm.getCourseId());
				courseList.add(course);
			}
			
			return courseList;
			
		} catch (PersistenceException pe) {
			return null;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<User> getRosterByCourseId(Id courseId) {
		List<User> roster = new ArrayList<User>();
		
		try {
			List<CourseMembership> cmList = CourseMembershipDbLoader.Default.getInstance().loadByCourseId(courseId);
			ListIterator<CourseMembership> cmIt = cmList.listIterator();
			
			while (cmIt.hasNext()) {
				CourseMembership curCm = cmIt.next();
				User user = UserDbLoader.Default.getInstance().loadUserByCourseMembership(curCm.getId());
				roster.add(user);
			}
			
			return roster;
			
		} catch (PersistenceException pe) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
