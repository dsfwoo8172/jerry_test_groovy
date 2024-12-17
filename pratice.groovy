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
}
