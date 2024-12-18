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

job('robot-notification') {
    description('')
    keepDependencies(false)
    properties {
        // DingTalk plugin configuration
        dingtalkJobProperty {
            notifierConfigs {
                dingtalkNotifierConfig {
                    raw(false)
                    disabled(false)
                    checked(true)
                    robotId('4d1055b4-43e9-4536-b445-aa0b80d62c44')
                    robotName('浪Live小幫手(測試)@機器人')
                    atAll(false)
                    atMobile('')
                    content('executed the deployment of a ${PROJECT_NAME} project. (TEST MESSAGE)\n\nURL: ${JOB_URL}')
                    message('')
                    noticeOccasions(['SUCCESS', 'FAILURE'])
                }
            }
        }
    }
    scm {
        // No SCM configured
    }
    canRoam(true)
    disabled(false)
    blockBuildWhenDownstreamBuilding(false)
    blockBuildWhenUpstreamBuilding(false)
    concurrentBuild(false)
    steps {
        shell('echo "Testing..."')
        shell('echo ${BUILD_NUMBER}')
    }
    // publishers {
    //     // No publishers configured
    // }
    // buildWrappers {
    //     // No build wrappers configured
    // }
}