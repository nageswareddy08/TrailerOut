package com.trailer.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trailer.dao.TrailerDAO;
import com.trailer.model.Trailer;

@Service
public class TrailerServiceImpl implements TrailerService {

    private TrailerDAO trailerDAO;

    public TrailerDAO getTrailerDAO() {
        return trailerDAO;
    }

    public void setTrailerDAO(TrailerDAO trailerDAO) {
        this.trailerDAO = trailerDAO;
    }

    @Override
    @Transactional
    public void addTrailer(Trailer trailer) {
        this.trailerDAO.addTrailer(trailer);

    }

    @Override
    @Transactional
    public void updateTrailer(Trailer trailer) {
        this.trailerDAO.updateTrailer(trailer);

    }

    @Override
    @Transactional
    public Trailer getTrailerByVid(String vid) {
        return this.trailerDAO.getTrailerByVid(vid);
    }

    @Override
    @Transactional
    public List<Trailer> listTrailers() {
        return this.trailerDAO.listTrailers();
    }

    @Override
    @Transactional
    public void removeTrailer(long vid) {
        this.trailerDAO.removeTrailer(vid);

    }


}
