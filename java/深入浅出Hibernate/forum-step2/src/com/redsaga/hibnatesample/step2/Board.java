package com.redsaga.hibnatesample.step2;

import java.util.Date;

import com.redsaga.hibnatesample.step2.base.BaseBoard;

/**
 * This is the object class that relates to the board table.
 * Any customizations belong here.
 */
public class Board extends BaseBoard {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Board () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Board (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Board (
		java.lang.Integer _id,
		com.redsaga.hibnatesample.step2.User _createBy,
		com.redsaga.hibnatesample.step2.Board _parent,
		java.util.Date _createTime,
		java.lang.String _name) {

		super (
			_id,
			_createBy,
			_parent,
			_createTime,
			_name);
	}
/*[CONSTRUCTOR MARKER END]*/
	protected void initialize () {
		setCreateTime(new Date());
	}
	
}