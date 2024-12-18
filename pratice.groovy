def configureDingTalk(Map config) {
    return { project ->
        def properties = project / 'properties'
        def dingtalk = properties / 'io.jenkins.plugins.DingTalkJobProperty'
        dingtalk / 'notifierConfigs' / 'io.jenkins.plugins.DingTalkNotifierConfig' {
            delegate.with {
                raw(config.raw ?: false)
                disabled(config.disabled ?: false)
                checked(config.checked ?: true)
                robotId(config.robotId)
                robotName(config.robotName)
                atAll(config.atAll ?: false)
                atMobile(config.atMobile ?: '')
                content(config.content ?: 'executed the deployment of a ${PROJECT_NAME} project.\n\nURL: ${JOB_URL}')
                message(config.message ?: '')
            }
            noticeOccasions {
                config.occasions?.each { occasion ->
                    string(occasion)
                } ?: {
                    string('SUCCESS')
                    string('FAILURE')
                }
            }
        }
    }
}

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
    description('測試dingtalk通知')
    
    configure configureDingTalk(
        robotId: '4d1055b4-43e9-4536-b445-aa0b80d62c44',
        robotName: '浪Live小幫手(測試)@機器人',
        atAll: true,
        content: '自定義通知內容：${PROJECT_NAME} 構建完成'
    )

    steps {
        shell('echo "Testing..."')
        shell('echo ${BUILD_NUMBER}')
    }
}

// job('example-job') {
//     description('')
    
//     // 使用 delegate 來避免命名衝突
//     configure { project ->
//         def properties = project / 'properties'
//         def dingtalk = properties / 'io.jenkins.plugins.DingTalkJobProperty'
//         dingtalk / 'notifierConfigs' / 'io.jenkins.plugins.DingTalkNotifierConfig' {
//             delegate.with {
//                 raw(false)
//                 disabled(false)
//                 checked(true)
//                 robotId('4d1055b4-43e9-4536-b445-aa0b80d62c44')
//                 robotName('浪Live小幫手(測試)@機器人')
//                 atAll(false)
//                 atMobile('')
//                 content('executed the deployment of a ${PROJECT_NAME} project. (TEST MESSAGE)\n\nURL: ${JOB_URL}')
//                 message('')
//             }
//             noticeOccasions {
//                 string('SUCCESS')
//                 string('FAILURE')
//             }
//         }
//     }
    
//     steps {
//         shell('echo "Testing..."')
//         shell('echo ${BUILD_NUMBER}')
//     }
// }