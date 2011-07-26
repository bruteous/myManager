package com.personnelmanager.domain.db.common.dao.impl.exception;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jun 30, 2010
 * Time: 6:04:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecordNonExistentException extends RuntimeException {
	public static String MESSAGE = "Record does not exist";
	public String getMessage() {
		return MESSAGE;
	}
}