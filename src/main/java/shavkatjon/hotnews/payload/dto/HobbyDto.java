package shavkatjon.hotnews.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HobbyDto {
    private String name;
    private List<UUID> tagsId;
}

