/*
 * Created on 2005-3-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test.com.redsaga.hibernatesample.step2;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author cao
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AllTests {

	public static void main(String[] args) {
	}

	public static Test suite() {
		TestSuite suite = new TestSuite(
			"Test for test.com.redsaga.hibernatesample.step2");
		//$JUnit-BEGIN$
		suite.addTestSuite(UserDAOTest.class);
		suite.addTestSuite(TestUserCRUD.class);
		suite.addTestSuite(TestBoardArticleMasterDetail.class);
		suite.addTestSuite(TestArticleTree.class);
		suite.addTestSuite(TestBoardTree.class);
		suite.addTestSuite(TestInterceptor.class);
//		suite.addTestSuite(TestHibernateForumServiceFunctional.class);
		//$JUnit-END$
		return suite;
	}
}