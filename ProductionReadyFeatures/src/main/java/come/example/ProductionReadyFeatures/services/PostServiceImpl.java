package come.example.ProductionReadyFeatures.services;


import come.example.ProductionReadyFeatures.Exceptions.ResourceNotFoundException;
import come.example.ProductionReadyFeatures.dto.PostDto;
import come.example.ProductionReadyFeatures.entities.PostEntity;
import come.example.ProductionReadyFeatures.entities.User;
import come.example.ProductionReadyFeatures.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
     private final ModelMapper modelMapper;
    @Override
    public List<PostDto> getAllPost() {
        return postRepository.findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public PostDto createNewPost(PostDto inputPost) {
        
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);

        return modelMapper.map(postRepository.save(postEntity),PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        User userId = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info("userId {}", userId);

        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post not found with id "+postId));
        return modelMapper.map(postEntity,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto inputPost, Long postId) {
        PostEntity olderPost = postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post not found with id "+postId));
        inputPost.setId(postId);
        modelMapper.map(inputPost, olderPost);
        PostEntity savedPostEntity = postRepository.save(olderPost);
        return modelMapper.map(savedPostEntity, PostDto.class);
    }
}
