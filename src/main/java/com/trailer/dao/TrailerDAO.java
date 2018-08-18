package com.trailer.dao;

import java.util.List;

import com.trailer.model.Trailer;

public interface TrailerDAO {

    public void addTrailer(Trailer trailer);

    public void updateTrailer(Trailer trailer);

    public Trailer getTrailerByVid(String vid);

    public List<Trailer> listTrailers();

    public void removeTrailer(long vid);

}
