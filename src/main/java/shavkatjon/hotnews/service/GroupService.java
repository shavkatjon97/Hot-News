package shavkatjon.hotnews.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shavkatjon.hotnews.repository.GroupsRepository;

@Service
@RequiredArgsConstructor
public class GroupService {

    final GroupsRepository groupsRepository;
}
