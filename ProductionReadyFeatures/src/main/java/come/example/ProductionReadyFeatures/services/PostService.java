package come.example.ProductionReadyFeatures.services;


import come.example.ProductionReadyFeatures.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    List<PostDto> getAllPost();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);

    PostDto updatePost(PostDto inputPost, Long postId);
}
