package guru.springframework.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Customer {
    private UUID id;
    private String customerName;
    private long version;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
