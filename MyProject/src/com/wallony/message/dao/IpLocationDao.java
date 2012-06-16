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

@Repository("IpLocationDao")
@Scope
@Transactional
public class IpLocationDao extends HibernateBaseDao {
	
	public Object save(Object o) {
		getHibernateTemplate().saveOrUpdate(o);
		return o;
	}

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
	
}
