job('pratice-via-DSL') {
    steps {
        shell('echo "Hello, World!"')
    }

    scm {
        git("https://github.com/dsfwoo8172/rent_house.git", "main")
    }

    triggers {
        scm('* * * * *')
    }
    
    publishers {
        dingtalk(
            robot: "4d1055b4-43e9-4536-b445-aa0b80d62c44",
            type: "MARKDOWN",
            title: "${JOB_NAME}",
            text: ["- 测试"]
        )
    }
    
}