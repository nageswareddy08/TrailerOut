package com.trailer.service;

import java.util.List;

import com.trailer.model.Trailer;

public interface TrailerService {

    public void addTrailer(Trailer trailer);

    public void updateTrailer(Trailer trailer);

    public Trailer getTrailerByVid(String vid);

    public List<Trailer> listTrailers();

    public void removeTrailer(long vid);

}
