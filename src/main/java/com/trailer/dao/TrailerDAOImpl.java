package com.trailer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trailer.model.Trailer;

public class TrailerDAOImpl implements TrailerDAO {

    // private static final Logger logger =
    // LoggerFactory.getLogger(PersonDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addTrailer(Trailer trailer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(trailer);
        // logger.info("Trailer saved successfully, Trailer Details="+trailer);
    }

    @Override
    public void updateTrailer(Trailer trailer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(trailer);
        // logger.info("Trailer updated successfully, Person Details="+p);

    }

    @Override
    public Trailer getTrailerByVid(String vid) {
        Session session = this.sessionFactory.getCurrentSession();
        Trailer trailer = (Trailer) session.load(Trailer.class, new Long(vid));
        // logger.info("Trailer loaded successfully, Trailer details="+trailer);
        return trailer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Trailer> listTrailers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Trailer> trailersList = session.createQuery("from Trailer").list();
        for (Trailer trailer : trailersList) {
            System.out.println("Trailer Details : " + trailer);
//            logger.info("Person List::"+p);
        }
        return trailersList;
    }

    @Override
    public void removeTrailer(long vid) {
        Session session = this.sessionFactory.getCurrentSession();
        Trailer trailer = (Trailer) session.load(Trailer.class, new Long(vid));
        if (null != trailer) {
            session.delete(trailer);
        }
//	        logger.info("Trailer deleted successfully, Trailer details="+trailer);

    }

}
