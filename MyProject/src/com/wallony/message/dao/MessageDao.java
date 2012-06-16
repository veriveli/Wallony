package com.wallony.message.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wallony.object.Persistable;

@Repository("MessageDao")
@Scope
@Transactional
public class MessageDao extends HibernateBaseDao {
	


//	public List<Long> setBannerPlanListByPositionId(long positionId){
//		Calendar cal = Calendar.getInstance();
//		int month = (cal.get(Calendar.MONTH)+1);
//		int day = cal.get(Calendar.DAY_OF_MONTH);
//		String today = cal.get(Calendar.YEAR) + "-" + (month<10 ? ("0"+month) : month) + "-" + (day<10 ? "0"+day : day) + " 00:00:00";
//		return (List<Long>)getHibernateTemplate().find("select id from BannerPlan where positionId=? and active=true and beginDate <= '"+today+"'", positionId);
//	}
	
	@SuppressWarnings("unchecked")
	public <P extends Persistable> List<P> listx(final Class<P> clazz, final String wherePart) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				StringBuilder hql = new StringBuilder();
				hql.append("from " + clazz.getName());
				hql.append(" ");
				hql.append("where");
				hql.append(" ");
				hql.append(" active = true and ");
				hql.append(wherePart);
				
				Query q = session.createQuery( hql.toString() );
				
				return q.list();
			}
		});
	}
	
	public Object save(Object o) {
		getHibernateTemplate().save(o);
		return o;
	}
	
	public Object update(Object o) {
		getHibernateTemplate().update(o);
		return o;
	}

}
