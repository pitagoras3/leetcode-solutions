import AddTwoNumbers.ListNode
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields

class Test_2_AddTwoNumbers : StringSpec({

    val example1 = row(
        ListNode(2).apply {
            next = ListNode(4).apply {
                next = ListNode(3)
            }
        },
        ListNode(5).apply {
            next = ListNode(6).apply {
                next = ListNode(4)
            }
        },
        ListNode(7).apply {
            next = ListNode(0).apply {
                next = ListNode(8)
            }
        }
    )


    val example2 = row(
        ListNode(9),
        ListNode(1).apply {
            next = ListNode(9).apply {
                next = ListNode(9).apply {
                    next = ListNode(9).apply {
                        next = ListNode(9).apply {
                            next = ListNode(9).apply {
                                next = ListNode(9).apply {
                                    next = ListNode(9).apply {
                                        next = ListNode(9).apply {
                                            next = ListNode(9).apply {}
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },
        ListNode(0).apply {
            next = ListNode(0).apply {
                next = ListNode(0).apply {
                    next = ListNode(0).apply {
                        next = ListNode(0).apply {
                            next = ListNode(0).apply {
                                next = ListNode(0).apply {
                                    next = ListNode(0).apply {
                                        next = ListNode(0).apply {
                                            next = ListNode(0).apply {
                                                next = ListNode(1).apply {}
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )

    val example3 = row(
        ListNode(9).apply {
            next = ListNode(9).apply {
                next = ListNode(9).apply {
                    next = ListNode(9).apply {
                        next = ListNode(9).apply {
                            next = ListNode(9).apply {
                                next = ListNode(9)
                            }
                        }
                    }
                }
            }
        },
        ListNode(9).apply {
            next = ListNode(9).apply {
                next = ListNode(9).apply {
                    next = ListNode(9)
                }
            }
        },
        ListNode(8).apply {
            next = ListNode(9).apply {
                next = ListNode(9).apply {
                    next = ListNode(9).apply {
                        next = ListNode(0).apply {
                            next = ListNode(0).apply {
                                next = ListNode(0).apply {
                                    next = ListNode(1).apply {

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )

    "should correctly perform adding two numbers" {
        forAll(example1, example2, example3) { list1, list2, expectedOutput ->
            AddTwoNumbers.addTwoNumbers(list1, list2)!! shouldBeEqualToComparingFields expectedOutput
        }
    }
})
