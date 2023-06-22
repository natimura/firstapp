package in.techcamp.firstapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @GetMapping("/hello")
    public String showHello(Model model){
        var sampleText = "サンプルテキスト";
        model.addAttribute("sampleText", sampleText);
        return "hello";
    }

    @GetMapping("/")
    public String showList(Model model){
        var postlist = postRepository.findAll();
        model.addAttribute("postList", postlist);
        return "index";
    }

    @GetMapping("/postForm")
    public String showPostForm(@ModelAttribute("postForm")PostForm form){
        return "postForm";
    }

    @PostMapping("/posts")
    public String savePost(PostForm form){
        postRepository.insert(form.getMemo());
        return "redirect:/";
    }
}
