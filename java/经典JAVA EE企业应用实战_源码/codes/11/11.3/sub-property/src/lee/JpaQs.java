package lee;

import java.util.List;
import javax.persistence.*;

import org.crazyit.model.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> 
 * <br/>Copyright (C), 2001-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */

public class JpaQs
{
	//一个持久单元对应一个EntityManagerFactory
	private static final EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("qs");
	public static void main(String[] args)
	{
		EntityManager em = emf.createEntityManager();
		try
		{
			//开启事务
			em.getTransaction().begin();
			Query query = em.createQuery("select news.title , news.content"
				+ " from News as news where news.id < ?1"
				+ " and news.title like :title");
			//为JPQL中第一个参数设置值。
			List result = query.setParameter(1 , 4)
				// 为JPQL中名为name的参数设置参数值
				.setParameter("title" , "%Java%")
				// 获取查询到的结果
				.getResultList();
			for (int i = 0 ; i < result.size() ; i++)
			{
				Object[] values = (Object[])result.get(i);
				//第一个数组元素是title属性，第二个数组元素是content属性
				System.out.println(values[0] + "-->"
					+ values[1]);
			}
			//提交事务
			em.getTransaction().commit();
		} 
		finally 
		{
			em.close();
		}
	}
}