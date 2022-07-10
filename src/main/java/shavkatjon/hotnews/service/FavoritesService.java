package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shavkatjon.hotnews.repository.FavoritesRepository;

@Service
@RequiredArgsConstructor
public class FavoritesService {

    final FavoritesRepository favoritesRepository;

}
