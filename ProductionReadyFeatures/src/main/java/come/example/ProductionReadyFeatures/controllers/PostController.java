package come.example.ProductionReadyFeatures.controllers;


import come.example.ProductionReadyFeatures.dto.PostDto;
import come.example.ProductionReadyFeatures.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {


    private final PasswordEncoder passwordEncoder;
    private final PostService postService;
    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPost();
    }


    @GetMapping("/carts")
    public String cartPage(){
        return "cart page";
    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable Long postId){
        return postService.getPostById(postId );
    }

    @PostMapping
    public PostDto createNewPost(@RequestBody PostDto inputPost){
        return postService.createNewPost(inputPost);
    }

    @PutMapping("/{postId}")
    public PostDto updatePost(@RequestBody PostDto inputPost, @PathVariable Long postId){
        return postService.updatePost(inputPost, postId);
    }

}
