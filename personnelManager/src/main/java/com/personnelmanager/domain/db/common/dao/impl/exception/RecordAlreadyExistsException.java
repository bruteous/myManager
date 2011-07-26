package com.personnelmanager.domain.db.common.dao.impl.exception;

/**
 * Created by IntelliJ IDEA.
 * User: MikeChen
 * Date: Jun 30, 2010
 * Time: 6:05:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecordAlreadyExistsException extends RuntimeException {
	public static String MESSAGE = "Record already exists";
	public String getMessage() {
		return MESSAGE;
	}
}