package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shavkatjon.hotnews.repository.SavedMessagesRepository;

@Service
@RequiredArgsConstructor
public class SavedMessagesService {

    final SavedMessagesRepository savedMessagesRepository;

}
