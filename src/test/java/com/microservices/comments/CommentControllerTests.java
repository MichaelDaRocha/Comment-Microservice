// package com.microservices.comments;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.MockMvcBuilder;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.ObjectWriter;
// import com.microservices.comments.controller.CommentController;
// import com.microservices.comments.model.Comment;
// import com.microservices.comments.repository.CommentRepository;

// @ExtendWith(MockitoExtension.class)
// public class CommentControllerTests {
    
//     @Autowired
//     private MockMvc mockMvc;

//     ObjectMapper objectMapper = new ObjectMapper();
//     ObjectWriter objectWriter = objectMapper.writer();

//     @Mock
//     CommentRepository repository;

//     @InjectMocks
//     CommentController controller;

//     Comment c1 = new Comment("Michael", "Hello World!", "Testing", null);
//     Comment c2 = new Comment("David", "Hello!", "T", null);
//     Comment c3 = new Comment("Benjamin", "World!", "Test", null);

//     @BeforeEach
//     void setup(){
//         this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//     }

//     @Test
//     public void test1(){
//         List<Comment> list = new ArrayList<Comment>(Arrays.asList(c1, c2, c3));
//         Mockito.when(repository.findAll()).thenReturn(list);

//         mockMvc.perform(MockMvcRequestBuilders
//             .get("/api")
//             .    
//         )
//     }

//     @Test
//     public void test2(){

//     }

//     @Test
//     public void test3(){
        
//     }
// }
